package org.multibit.hd.core.api;

/**
 * <p>Enum to provide the following to application:</p>
 * <ul>
 * <li>Message keys to use for internationalisation</li>
 * </ul>
 *
 * @since 0.0.1
 *         
 */
public enum MessageKey {

  // Verbs
  APPLY("apply"),
  UNDO("undo"),
  CANCEL("cancel"),
  EXIT("exit"),
  SEND("send"),
  RECEIVE("receive"),
  FINISH("finish"),
  CLOSE("close"),

  // Nouns
  YES("yes"),
  NO("no"),
  NEXT("next"),
  PREVIOUS("previous"),


  // Panels
  PEER_COUNT("status.peerCount"),
  CHAIN_DOWNLOAD("status.chainDownload"),
  START_NETWORK_CONNECTION_ERROR("bitcoin-network.start-network-connection-error"),
  NETWORK_CONFIGURATION_ERROR("bitcoin-network.configuration-error"),
  USE_LANGUAGE_LABEL("showPreferencesPanel.useSpecific"),
  HELP_LABEL("multiBitFrame.helpMenuText"),
  SETTINGS_LABEL("showPreferencesPanel.title"),

  SEND_TITLE_LABEL("sendBitcoinAction.text"),
  CONFIRM_SEND_TITLE_LABEL("sendBitcoinConfirmView.title"),
  CONFIRM_SEND_MESSAGE_LABEL("sendBitcoinConfirmView.message"),
  SEND_PROGRESS_TITLE_LABEL("Send Progress"),
  EXIT_TITLE_LABEL("Exit application ?"),

  BROADCAST_STATUS_OK("Broadcast OK"),
  RELAY_STATUS_OK("Relayed OK"),
  CONFIRMATION_STATUS_OK("Confirmations 6+"),
  ALERT_REMAINING("alert.remaining"),
  EXCHANGE_FIAT_RATE("exchange.fiat-rate"),
  // End of enum
  ;

  private final String key;


  private MessageKey(String key) {
    this.key = key;
  }

  /**
   * @return The key for use with the resource bundles
   */
  public String getKey() {
    return key;
  }
}