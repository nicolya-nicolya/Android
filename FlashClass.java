package ru.nicolas.firstapp;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

public class FlashClass {
    private boolean flash_status = false;
    private Context context;

    public FlashClass (Context context){
        this.context = context;
    }
    public void flash_on(){
        CameraManager cameraManager = (CameraManager)context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String CameraID = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(CameraID, true);
            flash_status = true;

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    public void flash_off(){
        CameraManager cameraManager = (CameraManager)context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String CameraID = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(CameraID,false);
            flash_status = false;

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    public boolean isFlash_status() {
        return flash_status;
    }
}
