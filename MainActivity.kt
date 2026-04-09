private fun checkOverlayPermission() {
    if (!Settings.canDrawOverlays(this)) {
        val intent = Intent(
            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:$packageName")
        )
        startActivityForResult(intent, 123)
    } else {
        startService(Intent(this, ViciousOverlayService::class.java))
    }
}
