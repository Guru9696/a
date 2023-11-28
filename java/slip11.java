// Heart Model
class HeartModel {
    private int heartRate;

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
        System.out.println("Heart rate set to " + heartRate + " bpm");
    }
}

// Beat Model
interface BeatModel {
    int getBeatsPerMinute();
    void setBeatsPerMinute(int beatsPerMinute);
    void registerObserver(BeatObserver observer);
    void removeObserver(BeatObserver observer);
    void notifyObservers();
}

// Adapter class to adapt HeartModel to BeatModel
class HeartAdapter implements BeatModel {
    private HeartModel heartModel;
    private int beatsPerMinute;

    public HeartAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
        this.beatsPerMinute = 0;
    }

    @Override
    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }

    @Override
    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
        heartModel.setHeartRate(beatsPerMinute);
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        // Not implemented in this example
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        // Not implemented in this example
    }

    @Override
    public void notifyObservers() {
        // Not implemented in this example
    }
}

// Observer interface for Beat Model
interface BeatObserver {
    void updateBeat();
}

// Concrete BeatObserver implementation
class ConsoleBeatObserver implements BeatObserver {
    @Override
    public void updateBeat() {
        System.out.println("Beat received.");
    }
}

public class slip11 {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        BeatModel beatModel = new HeartAdapter(heartModel);

        // Register a BeatObserver
        BeatObserver observer = new ConsoleBeatObserver();
        beatModel.registerObserver(observer);

        // Update the beats per minute through the adapter
        beatModel.setBeatsPerMinute(80);
    }
}

