package com.example.me.ui.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("has_point_categories")
    @Expose
    private boolean hasPointCategories;
    @SerializedName("organization_chat")
    @Expose
    private String organizationChat;
    @SerializedName("user_details")
    @Expose
    private UserDetails userDetails;
    @SerializedName("auth_provider")
    @Expose
    private String authProvider;
    @SerializedName("organization_logo")
    @Expose
    private String organizationLogo;
    @SerializedName("has_discount_categories")
    @Expose
    private boolean hasDiscountCategories;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("organization_theme_color")
    @Expose
    private String organizationThemeColor;
    @SerializedName("organization_settings")
    @Expose
    private OrganizationSettings organizationSettings;
    @SerializedName("organization_img_splash_screen")
    @Expose
    private String organizationImgSplashScreen;

    public boolean isHasPointCategories() {
        return hasPointCategories;
    }

    public void setHasPointCategories(boolean hasPointCategories) {
        this.hasPointCategories = hasPointCategories;
    }

    public String getOrganizationChat() {
        return organizationChat;
    }

    public void setOrganizationChat(String organizationChat) {
        this.organizationChat = organizationChat;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(String authProvider) {
        this.authProvider = authProvider;
    }

    public String getOrganizationLogo() {
        return organizationLogo;
    }

    public void setOrganizationLogo(String organizationLogo) {
        this.organizationLogo = organizationLogo;
    }

    public boolean isHasDiscountCategories() {
        return hasDiscountCategories;
    }

    public void setHasDiscountCategories(boolean hasDiscountCategories) {
        this.hasDiscountCategories = hasDiscountCategories;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOrganizationThemeColor() {
        return organizationThemeColor;
    }

    public void setOrganizationThemeColor(String organizationThemeColor) {
        this.organizationThemeColor = organizationThemeColor;
    }

    public OrganizationSettings getOrganizationSettings() {
        return organizationSettings;
    }

    public void setOrganizationSettings(OrganizationSettings organizationSettings) {
        this.organizationSettings = organizationSettings;
    }

    public String getOrganizationImgSplashScreen() {
        return organizationImgSplashScreen;
    }

    public void setOrganizationImgSplashScreen(String organizationImgSplashScreen) {
        this.organizationImgSplashScreen = organizationImgSplashScreen;
    }

    public class OrganizationSettings {

        @SerializedName("step_activity_limit")
        @Expose
        private int stepActivityLimit = -1;
        @SerializedName("enable_facility_checkin")
        @Expose
        private int enableFacilityCheckin = -1;
        @SerializedName("enable_activity_tracker")
        @Expose
        private int enableActivityTracker = -1;
        @SerializedName("enable_referral_page")
        @Expose
        private int enableReferralPage = -1;
        @SerializedName("activate_stars")
        @Expose
        private int activateStars = -1;

        public int getStepActivityLimit() {
            return stepActivityLimit;
        }

        public void setStepActivityLimit(int stepActivityLimit) {
            this.stepActivityLimit = stepActivityLimit;
        }

        public int getEnableFacilityCheckin() {
            return enableFacilityCheckin;
        }

        public void setEnableFacilityCheckin(int enableFacilityCheckin) {
            this.enableFacilityCheckin = enableFacilityCheckin;
        }

        public int getEnableActivityTracker() {
            return enableActivityTracker;
        }

        public void setEnableActivityTracker(int enableActivityTracker) {
            this.enableActivityTracker = enableActivityTracker;
        }

        public int getEnableReferralPage() {
            return enableReferralPage;
        }

        public void setEnableReferralPage(int enableReferralPage) {
            this.enableReferralPage = enableReferralPage;
        }

        public int getActivateStars() {
            return activateStars;
        }

        public void setActivateStars(int activateStars) {
            this.activateStars = activateStars;
        }
    }

    public class UserDetails {

        @SerializedName("phone_number")
        @Expose
        private String phoneNumber;
        @SerializedName("office_phone_number")
        @Expose
        private String officePhoneNumber;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("is_staff")
        @Expose
        private boolean isStaff;
        @SerializedName("organization_slug")
        @Expose
        private String organizationSlug;
        @SerializedName("gender")
        @Expose
        private int gender;
        @SerializedName("martial_status")
        @Expose
        private String martialStatus;
        @SerializedName("department_name")
        @Expose
        private Object departmentName;
        @SerializedName("organization_name")
        @Expose
        private String organizationName;
        @SerializedName("is_superuser")
        @Expose
        private boolean isSuperuser;
        @SerializedName("profile_pic_url")
        @Expose
        private String profilePicUrl;
        @SerializedName("is_redemption")
        @Expose
        private boolean isRedemption;
        @SerializedName("date_of_birth")
        @Expose
        private Object dateOfBirth;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("pk")
        @Expose
        private int pk;
        @SerializedName("using_default_password")
        @Expose
        private boolean usingDefaultPassword;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("point_allocation")
        @Expose
        private boolean pointAllocation;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getOfficePhoneNumber() {
            return officePhoneNumber;
        }

        public void setOfficePhoneNumber(String officePhoneNumber) {
            this.officePhoneNumber = officePhoneNumber;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public boolean isIsStaff() {
            return isStaff;
        }

        public void setIsStaff(boolean isStaff) {
            this.isStaff = isStaff;
        }

        public String getOrganizationSlug() {
            return organizationSlug;
        }

        public void setOrganizationSlug(String organizationSlug) {
            this.organizationSlug = organizationSlug;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getMartialStatus() {
            return martialStatus;
        }

        public void setMartialStatus(String martialStatus) {
            this.martialStatus = martialStatus;
        }

        public Object getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(Object departmentName) {
            this.departmentName = departmentName;
        }

        public String getOrganizationName() {
            return organizationName;
        }

        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }

        public boolean isIsSuperuser() {
            return isSuperuser;
        }

        public void setIsSuperuser(boolean isSuperuser) {
            this.isSuperuser = isSuperuser;
        }

        public String getProfilePicUrl() {
            return profilePicUrl;
        }

        public void setProfilePicUrl(String profilePicUrl) {
            this.profilePicUrl = profilePicUrl;
        }

        public boolean isIsRedemption() {
            return isRedemption;
        }

        public void setIsRedemption(boolean isRedemption) {
            this.isRedemption = isRedemption;
        }

        public Object getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(Object dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getPk() {
            return pk;
        }

        public void setPk(int pk) {
            this.pk = pk;
        }

        public boolean isUsingDefaultPassword() {
            return usingDefaultPassword;
        }

        public void setUsingDefaultPassword(boolean usingDefaultPassword) {
            this.usingDefaultPassword = usingDefaultPassword;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isPointAllocation() {
            return pointAllocation;
        }

        public void setPointAllocation(boolean pointAllocation) {
            this.pointAllocation = pointAllocation;
        }

    }
}
