package myCollection;

public enum UnitOfMeasure {
    METERS {
        @Override
        public String toString() {
            return "метры";
        }
    },
    CENTIMETERS {
        @Override
        public String toString() {
            return "Сантиметры";
        }
    },
    SQUARE_METERS {
        @Override
        public String toString() {
            return "квадратные метры";
        }
    },
    MILLILITERS {
        @Override
        public String toString() {
            return "миллиметры";
        }
    };
}
