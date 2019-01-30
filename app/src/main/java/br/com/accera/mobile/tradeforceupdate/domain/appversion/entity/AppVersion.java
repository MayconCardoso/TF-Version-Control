package br.com.accera.mobile.tradeforceupdate.domain.appversion.entity;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public class AppVersion {
    private int versionCode;
    private String versionName;
    private String apkPath;
    private String imageLogo;

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode( int versionCode ) {
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
}
