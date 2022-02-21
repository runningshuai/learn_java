package learnEnum;

public enum methodType {
    UNARY,
    CLIENT_STREAMING,
    SERVER_STREAMING,
    BIDI_STREAMING,
    UNKNOWN;

    private void MethodType() {
    }

    public final boolean clientSendsOneMessage() {
        return this == UNARY || this == SERVER_STREAMING;
    }

    public final boolean serverSendsOneMessage() {
        return this == UNARY || this == CLIENT_STREAMING;
    }
}


