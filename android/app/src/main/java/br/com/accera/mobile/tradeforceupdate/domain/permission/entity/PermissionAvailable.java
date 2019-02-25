package br.com.accera.mobile.tradeforceupdate.domain.permission.entity;

/**
 * Created by Rafael Spitaliere on 25/02/19.
 */
public enum PermissionAvailable {

    VERSION_CREATE("version_create"),
    USER_CAN_APPROVE("user_can_approve"),
    REGISTER_INSTANCE("register_instance"),
    DO_DEPLOY("do_deploy"),
    SCHEDULE_DEPLOY("schedule_deploy"),
    UPDATE_USER_INFO("update_user_info");

    private String action;

    PermissionAvailable(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

}
