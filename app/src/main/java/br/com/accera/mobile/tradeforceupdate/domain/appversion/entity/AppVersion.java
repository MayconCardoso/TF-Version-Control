package br.com.accera.mobile.tradeforceupdate.domain.appversion.entity;

import androidx.annotation.NonNull;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public class AppVersion {
    private String versionCode;
    private String versionName;
    private String apkPath;
    private String imageLogo;
    private String createdDate;

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode( String versionCode ) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName( String versionName ) {
        this.versionName = versionName;
    }

    public String getApkPath() {
        return apkPath;
    }

    public void setApkPath( String apkPath ) {
        this.apkPath = apkPath;
    }

    public String getImageLogo() {
        return imageLogo;
    }

    public void setImageLogo( String imageLogo ) {
        this.imageLogo = imageLogo;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate( String createdDate ) {
        this.createdDate = createdDate;
    }

    @NonNull
    @Override
    public String toString() {
        return getVersionName();
    }
}
