package org.multibit.hd.ui.views.wizards.credentials;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.*;
import net.miginfocom.swing.MigLayout;
import org.multibit.hd.core.concurrent.SafeExecutors;
import org.multibit.hd.core.events.SecurityEvent;
import org.multibit.hd.core.exceptions.ExceptionHandler;
import org.multibit.hd.core.services.CoreServices;
import org.multibit.hd.ui.MultiBitUI;
import org.multibit.hd.ui.audio.Sounds;
import org.multibit.hd.ui.events.view.ViewEvents;
import org.multibit.hd.ui.languages.Languages;
import org.multibit.hd.ui.languages.MessageKey;
import org.multibit.hd.ui.views.components.*;
import org.multibit.hd.ui.views.components.display_security_alert.DisplaySecurityAlertModel;
import org.multibit.hd.ui.views.components.display_security_alert.DisplaySecurityAlertView;
import org.multibit.hd.ui.views.components.enter_pin.EnterPinModel;
import org.multibit.hd.ui.views.components.enter_pin.EnterPinView;
import org.multibit.hd.ui.views.components.panels.PanelDecorator;
import org.multibit.hd.ui.views.fonts.AwesomeDecorator;
import org.multibit.hd.ui.views.fonts.AwesomeIcon;
import org.multibit.hd.ui.views.fonts.TitleFontDecorator;
import org.multibit.hd.ui.views.wizards.AbstractWizard;
import org.multibit.hd.ui.views.wizards.AbstractWizardPanelView;
import org.multibit.hd.ui.views.wizards.WizardButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * <p>View to provide the following to UI:</p>
 * <ul>
 * <li>Credentials: Enter pin</li>
 * </ul>
 *
 * @since 0.0.1
 *  
 */
public class CredentialsEnterPinPanelView extends AbstractWizardPanelView<CredentialsWizardModel, CredentialsEnterPinPanelModel> {

  private static final Logger log = LoggerFactory.getLogger(CredentialsEnterPinPanelView.class);

  // Panel specific components
  private ModelAndView<DisplaySecurityAlertModel, DisplaySecurityAlertView> displaySecurityPopoverMaV;
  private ModelAndView<EnterPinModel, EnterPinView> enterPinMaV;

  /**
   * A visual indicator of the number of pin characters entered
   */
  private JLabel pinIndicator;

  /**
   * A status indicator used to tell the user if PIN is incorrect
   */
  private JLabel statusIndicator;

  /**
   * A button that removes the last pin character entered
   */
  private JButton removeLast;


  final ListeningExecutorService checkPinExecutorService = SafeExecutors.newSingleThreadExecutor("check-pin");

  /**
   * @param wizard The wizard managing the states
   */
  public CredentialsEnterPinPanelView(AbstractWizard<CredentialsWizardModel> wizard, String panelName) {

    super(wizard, panelName, MessageKey.PIN_TITLE, AwesomeIcon.LOCK);

  }

  @Override
  public void newPanelModel() {

    displaySecurityPopoverMaV = Popovers.newDisplaySecurityPopoverMaV(getPanelName());
    enterPinMaV = Components.newEnterPinMaV(getPanelName());

    // Configure the panel model
    final CredentialsEnterPinPanelModel panelModel = new CredentialsEnterPinPanelModel(
      getPanelName(),
      enterPinMaV.getModel()
    );
    setPanelModel(panelModel);

    // Bind it to the wizard model
    getWizardModel().setEnterPinPanelModel(panelModel);

    // Register components
    registerComponents(displaySecurityPopoverMaV, enterPinMaV);

  }

  @Override
  public void initialiseContent(JPanel contentPanel) {

    contentPanel.setLayout(new MigLayout(
      Panels.migXLayout(),
      "[120][][][40]", // Column constraints
      "[]12[][][30]" // Row constraints
    ));

    pinIndicator = Labels.newBlankLabel();
    TitleFontDecorator.apply(pinIndicator, (float)(MultiBitUI.BALANCE_HEADER_LARGE_FONT_SIZE * 0.6));

    statusIndicator = Labels.newStatusLabel(Optional.<MessageKey>absent(), null, Optional.<Boolean>absent());

    removeLast = Buttons.newDeleteButton(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        enterPinMaV.getModel().removeLastButtonPressed();
      }
    });


    contentPanel.add(Labels.newBlankLabel());
    contentPanel.add(Labels.newPinIntroductionNote(), "align left,span 2,wrap");

    contentPanel.add(Labels.newBlankLabel());
    contentPanel.add(enterPinMaV.getView().newComponentPanel(), "align left,span 2, wrap");

    contentPanel.add(Labels.newBlankLabel());
    contentPanel.add(pinIndicator, "align left, growx");
    contentPanel.add(removeLast, "align right");
    contentPanel.add(Labels.newBlankLabel(), "wrap");

    contentPanel.add(statusIndicator, "span 4, wrap");
  }

  @Override
  protected void initialiseButtons(AbstractWizard<CredentialsWizardModel> wizard) {

    PanelDecorator.addExitCancelRestoreUnlock(this, wizard);

  }

  @Override
  public void fireInitialStateViewEvents() {

    // Initialise with "Unlock" disabled to force users to enter a credentials
    ViewEvents.fireWizardButtonEnabledEvent(
      getPanelName(),
      WizardButton.FINISH,
      false
    );

  }

  @Override
  public boolean beforeShow() {

    return true;
  }

  @Override
  public void afterShow() {

    registerDefaultButton(getFinishButton());

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {

        enterPinMaV.getView().requestInitialFocus();

        // Check for any security alerts
        Optional<SecurityEvent> securityEvent = CoreServices.getApplicationEventService().getLatestSecurityEvent();
        if (securityEvent.isPresent()) {

          displaySecurityPopoverMaV.getModel().setValue(securityEvent.get());

          // Show the security alert as a popover
          Panels.showLightBoxPopover(displaySecurityPopoverMaV.getView().newComponentPanel());

        }

      }
    });

  }

  @Override
  public boolean beforeHide(boolean isExitCancel) {

    // Don't block an exit
    if (isExitCancel) {
      return true;
    }

    // Start the spinner (we are deferring the hide)
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {

        // Ensure the view disables components
        getFinishButton().setEnabled(false);
        getExitButton().setEnabled(false);
        getRestoreButton().setEnabled(false);

      }
    });

    // Check the credentials
    ListenableFuture<Boolean> passwordFuture = checkPinExecutorService.submit(new Callable<Boolean>() {

      @Override
      public Boolean call() {

        // Need a very short delay here to allow the UI thread to update
        Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

        return checkPin();

      }
    });
    Futures.addCallback(passwordFuture, new FutureCallback<Boolean>() {

        @Override
        public void onSuccess(Boolean result) {

          // Check the result
          if (result) {

            // Manually deregister the MaVs
            CoreServices.uiEventBus.unregister(displaySecurityPopoverMaV);
            CoreServices.uiEventBus.unregister(enterPinMaV);

            // Trigger the deferred hide
            ViewEvents.fireWizardDeferredHideEvent(getPanelName(), false);

          } else {

            // Wait just long enough to be annoying (anything below 2 seconds is comfortable)
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

            // Failed
            Sounds.playBeep();

            // Ensure the view hides the spinner and enables components
            SwingUtilities.invokeLater(new Runnable() {
              @Override
              public void run() {

                getFinishButton().setEnabled(true);
                getExitButton().setEnabled(true);
                getRestoreButton().setEnabled(true);

                enterPinMaV.getView().requestInitialFocus();

                // Tell the user that the PIN check failed
                statusIndicator.setText(Languages.safeText(MessageKey.PIN_FAILURE));
                AwesomeDecorator.applyIcon(AwesomeIcon.CHECK, statusIndicator, true, MultiBitUI.NORMAL_ICON_SIZE);
              }
            });

          }

        }

        @Override
        public void onFailure(Throwable t) {

          // Ensure the view enables components
          SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

              getFinishButton().setEnabled(true);
              getExitButton().setEnabled(true);
              getRestoreButton().setEnabled(true);

              enterPinMaV.getView().requestInitialFocus();
            }
          });

          // Should not have seen an error
          ExceptionHandler.handleThrowable(t);
        }
      }
    );

    // Defer the hide operation
    return false;
  }

  /**
   * @return True if the Trezor states that the PIN is correct
   */
  private boolean checkPin() {

    log.debug("Performing a PIN check");
    CharSequence pin = enterPinMaV.getModel().getValue();

    // TODO talk to Trezor to check pin
    return true;
  }

  @Override
  public void updateFromComponentModels(Optional componentModel) {
    // Update the pinIndicator with the length of the entered pin
    CharSequence pin = enterPinMaV.getModel().getValue();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i <pin.length(); i++) {
      builder.append("*");
    }
    pinIndicator.setText(builder.toString());

    // Clear the PIN check status indicator
    statusIndicator.setText("");
    statusIndicator.setIcon(null);

    // Determine any events
    ViewEvents.fireWizardButtonEnabledEvent(
            getPanelName(),
            WizardButton.FINISH,
            isFinishEnabled()
    );

  }

  /**
   * @return True if the "finish" button should be enabled
   */
  private boolean isFinishEnabled() {

    return !Strings.isNullOrEmpty(
      getPanelModel().get()
        .getEnterPinModel()
        .getValue()
    );

  }

}