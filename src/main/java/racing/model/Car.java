package racing.model;

public class Car {

    private static final int MAX_NAME_SIZE = 5;
    public static final int CRITERIA_NUMBER = 4;
    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkNullName(name);
        name = name.trim();
        checkEmptyName(name);
        checkNameLengthUnderSix(name);
        this.name = name;
        this.position = new Position(position);
    }

    private void checkNullName(final String name) {
        if (name == null){
            throw new NullPointerException("차이름이 입력되지 않았습니다.");
        }
    }

    private void checkEmptyName(final String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("차이름은 공백 또는 빈 문자열일 수 없습니다.");
        }
    }

    private void checkNameLengthUnderSix(final String name) {
        if (name.length() > MAX_NAME_SIZE){
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public boolean isNameEqual(final Car car) {
        return this.name.equals(car.getName());
    }

    public void move(final int number){
        if (isMovable(number)){
            position.add();
        }
    }

    private boolean isMovable(final int number) {
        return number >= CRITERIA_NUMBER;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public Car getBiggerPositionCar(final Car targetCar) {
        checkTargetCarNull(targetCar);
        if (position.isBiggerThan(targetCar.getPosition())){
            return this;
        }
        return targetCar;
    }

    public boolean isSamePosition(final Car targetCar) {
        checkTargetCarNull(targetCar);
        return getPosition().equals(targetCar.getPosition());
    }

    private void checkTargetCarNull(final Car targetCar) {
        if (targetCar == null){
            throw new NullPointerException("비교할 차가 없습니다.");
        }
    }

    @Override
    public String toString(){
        return name;
    }

    public boolean equals(Car targetCar){
        return this.name.equals(targetCar.name);
    }
}