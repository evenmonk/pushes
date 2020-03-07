package filters;

import pushes.Push;

public interface PushFilter {
    Iterable<Push> filter(Iterable<Push> pushes);
}
