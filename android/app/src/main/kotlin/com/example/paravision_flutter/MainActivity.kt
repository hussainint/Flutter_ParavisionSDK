package com.example.paravision_flutter

import io.flutter.embedding.android.FlutterActivity

class MainActivity: FlutterActivity() {
    private val CHANNEL = "testSDK/test"
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "methodName") {

                startNewActivity(); // Method to start the SDK
            }
        }
    }


    private fun startNewActivity(): Int {
        val faceSDKInstance = ParavisionFaceSDK.Builder(applicationContext)
            .sdkMode(BENCHMARK)
            .build()
        startActivity(faceSDKInstance);

        return 12
    }

}
