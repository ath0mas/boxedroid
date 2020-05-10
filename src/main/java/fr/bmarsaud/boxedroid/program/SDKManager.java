package fr.bmarsaud.boxedroid.program;

import java.io.IOException;

import fr.bmarsaud.boxedroid.entity.ABI;
import fr.bmarsaud.boxedroid.entity.APILevel;
import fr.bmarsaud.boxedroid.entity.Variant;

/**
 * An abstraction of the SDKManager program from the Android SDK
 */
public class SDKManager extends Program {
    private String sdkPath;

    public SDKManager(String path, String sdkPath) {
        super(path);
        this.sdkPath = sdkPath;
    }

    /**
     * Run the "--licences" command accepting the Android SDK licences if needed
     * @return The process of the executed command
     */
    public Process acceptLicence() throws IOException {
        return this.execute("--sdk_root=" + sdkPath, "--licences");
    }

    /**
     * Run the command installing the system images of a certain API level, ABI and variant
     * @param apiLevel The API level of the system images to install
     * @param abi The ABI supported by the system images to install
     * @param variant The variant of the system images to install
     * @return The process of the executed command
     */
    public Process installSystemImage(APILevel apiLevel, ABI abi, Variant variant) throws IOException {
        return this.execute("--sdk_root=" + sdkPath,
                "system-images;android-" + apiLevel.getCode() + ";" + variant.getId() +";" + abi.getId());
    }
}
