package base.joiner;

import java.util.List;

public class LegacyJoiner {

    public String buildString(List<String> stringList, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (String s : stringList) {
            if (s != null) {
                builder.append(s).append(delimiter);
            }
        }

        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }
}
