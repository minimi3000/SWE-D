package service;

import java.util.Random;

public class UpdateChecker {
    public boolean hasUpdate(String url) {
        return new Random().nextBoolean(); // Random simulation
    }
}
