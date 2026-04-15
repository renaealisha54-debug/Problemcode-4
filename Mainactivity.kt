// Check for the draw-over-other-apps permission
if (!Settings.canDrawOverlays(this)) {
    val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
        Uri.parse("package:$packageName"))
    startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE)
} else {
    // Permission already granted, safe to start the service
    startService(Intent(this, ViciousOverlayService::class.java))
}
