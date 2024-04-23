package lab2.Problema1;

class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        super(latura1, latura2, latura3, latura4, unghi1, unghi2, unghi3, unghi4);
    }

    public float Arie() {
        float result;
        result = latura1 * latura2 * (float)Math.sin(Math.toRadians(unghi1));
        return result;
    }
}

class Romb extends  Paralelogram {
    private int diagonala1;
    private int diagonala2;
    public Romb(int latura1, int latura2, int latura3, int latura4,
                        double unghi1, double unghi2, double unghi3, double unghi4, int diagonala1, int diagonala2) {
        super(latura1, latura2, latura3, latura4, unghi1, unghi2, unghi3, unghi4);
        this.diagonala1 = diagonala1;
        this.diagonala2 = diagonala2;
    }
    public float Arie() {
        float result;
        result = (diagonala1 * diagonala2) / 2;
        return result;
    }
}

class Dreptunghi extends Paralelogram {
    public Dreptunghi(int latura1, int latura2, int latura3, int latura4,
                        double unghi1, double unghi2, double unghi3, double unghi4) {
        super(latura1, latura2, latura3, latura4, unghi1, unghi2, unghi3, unghi4);
    }
    public float Arie() {
        float result;
        result = (latura1 * latura2) / 2;
        return result;
    }
}

class Patrat extends  Dreptunghi {
    public Patrat(int latura1, int latura2, int latura3, int latura4,
                        double unghi1, double unghi2, double unghi3, double unghi4) {
        super(latura1, latura2, latura3, latura4, unghi1, unghi2, unghi3, unghi4);
    }
    public float Arie() {
        float result;
        result = (latura1 * latura1) / 2;
        return result;
    }
}