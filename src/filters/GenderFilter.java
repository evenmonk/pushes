package filters;

import pushes.Push;

import java.util.ArrayList;

public class GenderFilter implements PushFilter {
    @Override
    public Iterable<Push> filter(Iterable<Push> pushes) {
        return new ArrayList<Push>();
    }
}
