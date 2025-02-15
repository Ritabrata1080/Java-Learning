/**
 * Created by Ritabrata
 */

public class JNICalls {
    static {
        System.loadLibrary("JNICalls"); // Loads libJNICalls.dylib
    }

    // Native methods
    public native void printMessage();
    public native int addNumbers(int a, int b);
    public native String getGreeting();

    public static void main(String[] args) {
        JNICalls jni = new JNICalls();

        // Calling multiple JNI methods
        jni.printMessage();
        int sum = jni.addNumbers(5, 7);
        System.out.println("Sum from JNI: " + sum);

        String message = jni.getGreeting();
        System.out.println("Message from JNI: " + message);
    }
}
