package racing.model;

public class Position {
    private static final int STEP = 1;
    public static final int INITIAL_POSITION = 0;

    private int position;

    public Position (){
        this(INITIAL_POSITION);
    }

    public Position (int position){
        this.position = position;
    }

    public void add(){
        position += STEP;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o){
        if (this.position == ((Position)o).position && (o instanceof Position)){
            return true;
        }
        return false;
    }

    public boolean isBiggerThan(final Position targetPosition) {
        return this.position > targetPosition.position;
    }
}