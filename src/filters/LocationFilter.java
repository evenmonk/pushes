package filters;

import pushes.Push;

import java.util.ArrayList;

public class LocationFilter implements PushFilter {

    @Override
    public Iterable<Push> filter(Iterable<Push> pushes) {
        return new ArrayList<Push>();
    }
}
