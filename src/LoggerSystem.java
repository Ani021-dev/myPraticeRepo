package src;

abstract class LogProc {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProc nextLogProc;

    LogProc(LogProc logProc) {
        nextLogProc = logProc;
    }

    public void log(int logLevel, String msg) {
        if (nextLogProc != null) {
            nextLogProc.log(logLevel, msg);
        }
    }
}

class Info extends LogProc {

    Info(LogProc logProc) {
        super(logProc);
    }

    public void log(int logLevel, String msg) {
        if (logLevel == INFO) {
            System.out.println("Info Level " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}

class Debug extends LogProc {
    Debug(LogProc logProc) {
        super(logProc);
    }

    public void log(int logLevel, String msg) {
        if (logLevel == DEBUG) {
            System.out.println("DEBUG level " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}

class Error extends LogProc {

    Error(LogProc logProc) {
        super(logProc);
    }

    public void log(int logLevel, String msg) {
        if (logLevel == ERROR) {
            System.out.println("Error Level " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}

public class LoggerSystem {
    public static void main(String[] args) {
        LogProc logProc = new Info(new Debug(new Error(null)));

        logProc.log(LogProc.ERROR, "Exceptions @ Error");
        logProc.log(LogProc.DEBUG, "Exceptions @ DEBUG");
        logProc.log(LogProc.INFO, "Exceptions @ INFO");
    }
}
