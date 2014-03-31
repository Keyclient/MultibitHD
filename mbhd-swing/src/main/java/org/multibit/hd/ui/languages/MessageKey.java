package org.multibit.hd.ui.languages;

/**
 * <p>Enum to provide the following to application:</p>
 * <ul>
 * <li>Message keys to use for internationalisation</li>
 * </ul>
 *
 * <h3>Naming conventions</h3>
 * <p>Message keys are placed in an enum for type safety.</p>
 * <p>Message keys have their resource key so that IDEs can maintain a "where used" reference lookup.</p>
 * <p>Message keys are never concatenated to form larger sentences. Instead use token replacements
 * within a larger sentence structure.</p>
 * <p>Resource keys are simply the message key enum name in lower case.</p>
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
  REQUEST("request"),
  REFRESH("refresh"),
  FINISH("finish"),
  CLOSE("close"),
  SHOW("show"),
  HIDE("hide"),
  ADD("add"),
  EDIT("edit"),
  DELETE("delete"),
  RESTORE("restore"),

  // Nouns

  YES("yes"),
  NO("no"),
  NEXT("next"),
  PREVIOUS("previous"),
  ALL("all"),
  NONE("none"),
  ERROR("error"),
  DEFAULT("default"),

  // Adjectives
  LEADING("leading"),
  TRAILING("trailing"),

  // Field labels

  RECIPIENT("recipient"),
  TRANSACTION_LABEL("transaction_label"),
  QR_CODE_LABEL_LABEL("qr_code_label_label"),
  NOTES("notes"),
  ONE_OF_YOUR_ADDRESSES("one_of_your_addresses"),
  SELECT_FOLDER("select_folder"),
  SELECT_FILE("select_file"),

  ENTER_PASSWORD("enter_password"),
  ENTER_NEW_PASSWORD("enter_new_password"),
  RETYPE_NEW_PASSWORD("retype_new_password"),

  PASSWORD_VERIFIED("password_verified"),
  PASSWORD_FAILED("password_failed"),

  AMOUNT("amount"),
  AMOUNT_PAID("amount_paid"),
  TRANSACTION_FEE("transaction_fee"),
  DEVELOPER_FEE("developer_fee"),
  COINBASE("coinbase"),

  NAME("name"),
  NAMES("names"),
  EMAIL_ADDRESS("email_address"),
  BITCOIN_ADDRESS("bitcoin_address"),
  EXTENDED_PUBLIC_KEY("extended_public_key"),
  TAGS("tags"),
  EXAMPLE("example"),
  VERSION("version"),

  DISPLAY_LANGUAGE("display_language"),

  DISPLAY_THEME("display_theme"),

  SELECT_DECIMAL_SEPARATOR("select_decimal_separator"),
  SELECT_GROUPING_SEPARATOR("select_grouping_separator"),
  SELECT_LOCAL_SYMBOL("select_local_symbol"),
  SELECT_BITCOIN_SYMBOL("select_bitcoin_symbol"),
  SELECT_PLACEMENT("select_placement"),

  SELECT_EXCHANGE_RATE_PROVIDER("select_exchange_rate_provider"),
  SELECT_LOCAL_CURRENCY("select_local_currency"),
  ENTER_ACCESS_CODE("enter_access_code"),
  EXCHANGE_RATE_LABEL("exchange_rate_label"),
  NOT_AVAILABLE("not_available"),

  ALERT_SOUND("alert_sound"),
  RECEIVE_SOUND("receive_sound"),

  // Sidebar

  SEND_OR_REQUEST("send_or_request"),
  CONTACTS("contacts"),
  TRANSACTIONS("transactions"),
  HISTORY("history"),
  PREFERENCES("preferences"),
  TOOLS("tools"),

  // Placeholders
  APPROXIMATELY("approximately"),
  PARANTHESES("parantheses"),
  LIST_COMMA("list_comma"),
  LIST_ELLIPSIS("list_ellipsis"),
  DECIMAL_COMMA("decimal_comma"),
  DECIMAL_POINT("decimal_point"),
  DECIMAL_SPACE("decimal_space"),

  BITCOIN_URI_ALERT("bitcoin_uri_label"),

  PEER_COUNT("peer_count"),
  BLOCKS_LEFT("blocks_left"),
  LAST_TRANSACTION_ID("last_transaction_id"),

  // Panels

  NETWORK_CONFIGURATION_ERROR("network_configuration_error"),
  HELP("help"),
  SETTINGS("settings"),

  // Titles
  APPLICATION_TITLE("application_title"),

  RECEIVE_BITCOIN_TITLE("receive_bitcoin_title"),

  SEND_BITCOIN_TITLE("send_bitcoin_title"),
  CONFIRM_SEND_TITLE("confirm_send_title"),
  SEND_PROGRESS_TITLE("send_progress_title"),

  EXIT_TITLE("exit_title"),

  ABOUT_TITLE("about_title"),

  SECURITY_TITLE("security_title"),

  WELCOME_TITLE("welcome_title"),
  SELECT_WALLET_TITLE("select_wallet_title"),
  CREATE_WALLET_SEED_PHRASE_TITLE("create_wallet_seed_phrase_title"),
  CONFIRM_WALLET_SEED_PHRASE_TITLE("confirm_wallet_seed_phrase_title"),
  CREATE_WALLET_PASSWORD_TITLE("create_wallet_password_title"),
  SELECT_BACKUP_LOCATION_TITLE("select_backup_location_title"),
  CREATE_WALLET_REPORT_TITLE("create_wallet_report_title"),

  RESTORE_WALLET_SEED_PHRASE_TITLE("restore_wallet_seed_phrase_title"),
  RESTORE_WALLET_BACKUP_LOCATION_TITLE("restore_wallet_backup_location_title"),
  RESTORE_WALLET_SELECT_BACKUP_TITLE("restore_wallet_select_backup_title"),
  RESTORE_WALLET_TIMESTAMP_TITLE("restore_wallet_timestamp_title"),
  RESTORE_WALLET_REPORT_TITLE("restore_wallet_report_title"),

  NEW_CONTACT_TITLE("new_contact_title"),
  EDIT_CONTACT_TITLE("edit_contact_title"),
  EDIT_CONTACTS_TITLE("edit_contacts_title"),

  NEW_HISTORY_ENTRY_TITLE("new_history_entry_title"),
  EDIT_HISTORY_ENTRY_TITLE("edit_history_entry_title"),
  EDIT_HISTORY_ENTRIES_TITLE("edit_history_entries_title"),

  PASSWORD_TITLE("password_title"),
  PASSWORD_ENTER_SEED_PHRASE_TITLE("password_enter_seed_phrase_title"),
  PASSWORD_REPORT_TITLE("password_report_title"),
  PASSWORD_UNLOCK("password_unlock"),

  WALLET_DETAIL_TITLE("wallet_detail_title"),

  CHANGE_PASSWORD_TITLE("change_password_title"),

  VERIFY_NETWORK_TITLE("verify_network_title"),

  // Labels
  CONFIRM_SEND_MESSAGE("confirm_send_message"),
  EXCHANGE_RATE_PROVIDER("exchange_rate_provider"),
  BROADCAST_STATUS("broadcast_status"),
  RELAY_STATUS("relay_status"),
  CONFIRMATION_STATUS("confirmation_status"),
  VERIFICATION_STATUS("verification_status"),
  EXCHANGE_RATE_STATUS_OK("exchange_rate_status_ok"),
  EXCHANGE_RATE_STATUS_WARN("exchange_rate_status_warn"),
  SEED_PHRASE_CREATED_STATUS("seed_phrase_created_status"),
  WALLET_PASSWORD_CREATED_STATUS("wallet_password_created_status"),
  BACKUP_LOCATION_STATUS("backup_location_status"),
  SELECT_BACKUP("select_backup"),
  WALLET_CREATED_STATUS("wallet_created_status"),
  ALERT_REMAINING("alert_remaining"),
  EXCHANGE_FIAT_RATE("exchange_fiat_rate"),
  EXCHANGE_FIAT_RATE_WITH_PROVIDER("exchange_fiat_rate_with_provider"),
  SELECT_LANGUAGE("select_language"),
  SEED_SIZE("seed_size"),
  TIMESTAMP("timestamp"),
  MULTI_EDIT_NOTE("multi_edit_note"),

  // Tool buttons
  SHOW_WELCOME_WIZARD("show_welcome_wizard"),
  SHOW_SOUND_WIZARD("show_sound_wizard"),
  SHOW_BITCOIN_WIZARD("show_bitcoin_wizard"),
  SHOW_EXCHANGE_WIZARD("show_exchange_wizard"),
  SHOW_APPLICATION_WIZARD("show_application_wizard"),
  SHOW_LANGUAGE_WIZARD("show_language_wizard"),
  SHOW_WALLET_DETAILS_WIZARD("show_wallet_details_wizard"),
  SHOW_CHANGE_PASSWORD_WIZARD("show_change_password_wizard"),
  SHOW_VERIFY_NETWORK_WIZARD("show_verify_network_wizard"),

  SHOW_ALERT("show_alert"),
  HIDE_ALERT("hide_alert"),

  // Radio buttons
  CREATE_WALLET("create_wallet"),
  RESTORE_WALLET("restore_wallet"),
  SWITCH_WALLET("switch_wallet"),
  USE_HARDWARE_WALLET("use_hardware_wallet"),

  RESTORE_FROM_SEED_PHRASE("restore_from_seed_phrase"),
  RESTORE_FROM_BACKUP("restore_from_backup"),

  // Notes (can contain HTML),

  WELCOME_NOTE_1("welcome_note_1"),
  WELCOME_NOTE_2("welcome_note_2"),
  WELCOME_NOTE_3("welcome_note_3"),
  WELCOME_NOTE_4("welcome_note_4"),

  ABOUT_NOTE_1("about_note_1"),
  ABOUT_NOTE_2("about_note_2"),
  ABOUT_NOTE_3("about_note_3"),

  SELECT_BACKUP_LOCATION_NOTE_1("select_backup_location_note_1"),
  SELECT_BACKUP_LOCATION_NOTE_2("select_backup_location_note_2"),
  SELECT_BACKUP_LOCATION_NOTE_3("select_backup_location_note_3"),
  SELECT_BACKUP_LOCATION_NOTE_4("select_backup_location_note_4"),

  SELECT_BACKUP_NOTE_1("select_backup_note_1"),
  SELECT_BACKUP_NOTE_2("select_backup_note_2"),

  SEED_PRINT_NOTE_1("seed_print_note_1"),
  SEED_PRINT_NOTE_2("seed_print_note_2"),
  SEED_PRINT_NOTE_3("seed_print_note_3"),
  SEED_PRINT_NOTE_4("seed_print_note_4"),

  SEED_WARNING_NOTE_1("seed_warning_note_1"),
  SEED_WARNING_NOTE_2("seed_warning_note_2"),
  SEED_WARNING_NOTE_3("seed_warning_note_3"),
  SEED_WARNING_NOTE_4("seed_warning_note_4"),
  SEED_WARNING_NOTE_5("seed_warning_note_5"),

  CONFIRM_SEED_PHRASE_NOTE_1("confirm_seed_phrase_note_1"),
  CONFIRM_SEED_PHRASE_NOTE_2("confirm_seed_phrase_note_2"),
  CONFIRM_SEED_PHRASE_NOTE_3("confirm_seed_phrase_note_3"),
  CONFIRM_SEED_PHRASE_NOTE_4("confirm_seed_phrase_note_4"),

  WALLET_PASSWORD_NOTE_1("wallet_password_note_1"),
  WALLET_PASSWORD_NOTE_2("wallet_password_note_2"),
  WALLET_PASSWORD_NOTE_3("wallet_password_note_3"),

  RESTORE_METHOD_NOTE_1("restore_method_note_1"),
  RESTORE_METHOD_NOTE_2("restore_method_note_2"),
  RESTORE_METHOD_NOTE_3("restore_method_note_3"),
  RESTORE_METHOD_NOTE_4("restore_method_note_4"),

  RESTORE_BACKUP_NOTE_1("restore_backup_note_1"),
  RESTORE_BACKUP_NOTE_2("restore_backup_note_2"),
  RESTORE_BACKUP_NOTE_3("restore_backup_note_3"),

  RESTORE_SEED_PHRASE_NOTE_1("restore_seed_phrase_note_1"),
  RESTORE_SEED_PHRASE_NOTE_2("restore_seed_phrase_note_2"),
  RESTORE_SEED_PHRASE_NOTE_3("restore_seed_phrase_note_3"),

  RESTORE_TIMESTAMP_NOTE_1("restore_timestamp_note_1"),
  RESTORE_TIMESTAMP_NOTE_2("restore_timestamp_note_2"),
  RESTORE_TIMESTAMP_NOTE_3("restore_timestamp_note_3"),
  RESTORE_TIMESTAMP_NOTE_4("restore_timestamp_note_4"),

  PASSWORD_NOTE_1("password_note_1"),
  PASSWORD_NOTE_2("password_note_2"),

  CHANGE_PASSWORD_NOTE_1("change_password_note_1"),
  CHANGE_PASSWORD_NOTE_2("change_password_note_2"),

  VERIFY_NETWORK_NOTE_1("verify_network_note_1"),

  BITCOIN_SETTINGS_NOTE_1("bitcoin_settings_note_1"),

  EXCHANGE_SETTINGS_NOTE_1("exchange_settings_note_1"),

  LANGUAGE_CHANGE_NOTE_1("language_change_note_1"),

  THEME_CHANGE_NOTE_1("theme_change_note_1"),

  SOUND_CHANGE_NOTE_1("sound_change_note_1"),

  DATA_ENTERED_NOTE_1("data_entered_note_1"),
  DATA_ENTERED_NOTE_2("data_entered_note_2"),

  RECIPIENT_SUMMARY("recipient_summary"),
  AMOUNT_SUMMARY("amount_summary"),

  // Wallet detail panel
  APPLICATION_DIRECTORY("application_directory"),
  WALLET_DIRECTORY("wallet_directory"),

  // Payments panel and wizard
  DETAILS("details"),
  EXPORT("export"),
  DELETE_PAYMENT_REQUEST("delete_payment_request"),
  TRANSACTION_OVERVIEW("transaction_overview"),
  TRANSACTION_DETAIL("transaction_detail"),
  CHOOSE_PAYMENT_REQUEST("choose_payment_request"),
  CHOOSE_PAYMENT_REQUEST_LABEL("choose_payment_request_label"),
  PAYMENT_REQUEST_INFO_SINGULAR("payment_request_info_singular"),
  PAYMENT_REQUEST_INFO_PLURAL("payment_request_info_plural"),
  MATCHING_PAYMENT_REQUEST("matching_payment_request"),
  PAYMENT_REQUEST("payment_request"),
  DATE("date"),
  STATUS("status"),
  TYPE("type"),
  DESCRIPTION("description"),
  TRANSACTION_HASH("transaction_hash"),
  RAW_TRANSACTION("raw_transaction"),
  VIEW_IN_BLOCKCHAIN_INFO("view_in_blockchain_info"),
  SIZE("size"),
  SIZE_VALUE("size_value"),


  // Themes
  LIGHT_THEME("light_theme"),
  DARK_THEME("dark_theme"),

  // Date rendering
  TODAY("today"),
  YESTERDAY("yesterday"),

  // Export payments
  SELECT_EXPORT_PAYMENTS_LOCATION("select_export_payments_location"),
  EXPORT_PAYMENTS_REPORT("export_payments_report"),
  SELECT_EXPORT_PAYMENTS_LOCATION_NOTE_1("select_export_payments_location_note_1"),
  SELECT_EXPORT_PAYMENTS_LOCATION_NOTE_2("select_export_payments_location_note_2"),
  SELECT_EXPORT_PAYMENTS_LOCATION_NOTE_3("select_export_payments_location_note_3"),
  SELECT_EXPORT_PAYMENTS_LOCATION_NOTE_4("select_export_payments_location_note_4"),
  EXPORT_TRANSACTIONS_STEM("export_transactions_stem"),
  EXPORT_PAYMENT_REQUESTS_STEM("export_payment_requests_stem"),
  EXPORT_WAS_SUCCESSFUL("export_was_successful"),
  TRANSACTIONS_WERE_EXPORTED_TO_THE_FILE("transactions_were_exported_to_the_file"),
  PAYMENT_REQUESTS_WERE_EXPORTED_TO_THE_FILE("payment_requests_were_exported_to_the_file"),
  COULD_NOT_WRITE_TO_THE_DIRECTORY("could_not_write_to_the_directory"),

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
