package org.multibit.hd.ui.fest.use_cases.hardware_wallet;

import org.fest.swing.fixture.FrameFixture;
import org.multibit.hd.testing.HardwareWalletEventFixtures;
import org.multibit.hd.ui.fest.use_cases.AbstractFestUseCase;
import org.multibit.hd.ui.languages.Languages;
import org.multibit.hd.ui.languages.MessageKey;
import org.multibit.hd.ui.views.wizards.credentials.CredentialsState;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.fest.swing.timing.Timeout.timeout;

/**
 * <p>Use case to provide the following to FEST testing:</p>
 * <ul>
 * <li>Verify the Trezor "press confirm unlock device" screen</li>
 * </ul>
 *
 * <p>Require the panel view to be showing (event triggered earlier)</p>
 *
 * @since 0.0.5
 */
public class TrezorConfirmUnlockUseCase extends AbstractFestUseCase {

  public TrezorConfirmUnlockUseCase(FrameFixture window) {
    super(window);
  }

  @Override
  public void execute(Map<String, Object> parameters) {

    // Allow time for UI to catch up with events
    pauseForViewReset();

    // Check that the Trezor press confirm to wipe panel view is showing
    window
      .label(MessageKey.TREZOR_PRESS_CONFIRM_TITLE.getKey())
      .requireVisible();

    window
      .textBox(CredentialsState.CREDENTIALS_PRESS_CONFIRM_FOR_UNLOCK.name() + ".trezor_display")
      .requireText(Languages.safeText(MessageKey.TREZOR_ENCRYPT_MULTIBIT_HD_UNLOCK_DISPLAY))
      .requireVisible();

    // Cipher key Success
    HardwareWalletEventFixtures.fireNextEvent();

    // Allow time to unlock
    pauseForWalletUnlock();

    // Wait for Finish button to appear
    window
      .button(MessageKey.FINISH.getKey())
      .requireVisible()
        // Allow a short time to overcome initialisation delays
      .requireEnabled(timeout(1, TimeUnit.SECONDS))
      .click();

  }
}
