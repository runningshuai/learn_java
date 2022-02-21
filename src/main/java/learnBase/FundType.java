package learnBase;

import java.util.Optional;
import java.util.stream.Stream;

public enum FundType {
    P("私募", "P"),
    F("公募", "F"),
    CSI("组合", "CSI"),
    NONE("无", "");

    private String describe;
    private String prefix;

    FundType(String describe, String prefix) {
        this.describe = describe;
        this.prefix = prefix;
    }

    public static FundType judge(String symbol) {
        Optional<FundType> first = Stream.of(FundType.values())
                .filter(item ->
                        symbol.toUpperCase().startsWith(item.prefix)
                )
                .findFirst();
        return first.orElse(NONE);
    }
}
