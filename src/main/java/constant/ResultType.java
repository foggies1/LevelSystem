package constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResultType {

    INVALID_BALANCE("(NOT ENOUGH BALANCE) "),
    MAX_LEVEL("(MAX LEVEL) "),
    LEVEL_UP("(LEVEL UP ACTION) ");

    private final String prefix;

}
