package rave.code.quartz.enums;

public enum NSEClassification {

    EMPTY("Index", "Index"),

    EQ("EQ", "Equity"),
    SM("SM","Small and Medium sized Enterprise"),
    IV("IV","Implied Volatile"),
    RR("RR","RR Equity Series"),
    T0("T0","T+0(Settled on the same day)"),
    E1("E1","E1(Partly paid-up equity sharesy)"),

    BE("BE","Book Entry(Trade-to-Trade (T2T) segment)"),
    BL("BL","Book Entry(Trade-to-Trade (T2T) segment)"),
    BT("BT","Book Entry(Trade-to-Trade (T2T) segment)"),
    BZ("BZ","Blacklisted"),

    ST("ST","Blacklisted"),
    GB("GB","Blacklisted"),
    GS("GS","Blacklisted"),
    X1("X1","Blacklisted"),

    N0("N0","Blacklisted"), N1("N1","Blacklisted"), N2("N2","Blacklisted"), N3("N3","Blacklisted"), N4("N4","Blacklisted"),
    N5("N5","Blacklisted"), N6("N6","Blacklisted"), N7("N7","Blacklisted"), N8("N8","Blacklisted"), N9("N9","Blacklisted"),

    NA("NA","Blacklisted"), NB("NB","Blacklisted"), NC("NC","Blacklisted"), ND("ND","Blacklisted"),
    NE("NE","Blacklisted"), NF("NF","Blacklisted"), NG("NG","Blacklisted"), NH("NH","Blacklisted"),
    NI("NI","Blacklisted"), NJ("NJ","Blacklisted"), NK("NK","Blacklisted"), NL("NL","Blacklisted"),
    NM("NM","Blacklisted"), NN("NN","Blacklisted"), NO("NO","Blacklisted"), NP("NP","Blacklisted"),
    NQ("NQ","Blacklisted"), NR("NR","Blacklisted"), NS("NS","Blacklisted"), NT("NT","Blacklisted"),
    NU("NU","Blacklisted"), NV("NV","Blacklisted"), NW("NW","Blacklisted"), NX("NX","Blacklisted"),
    NY("NY","Blacklisted"), NZ("NZ","Blacklisted"),

    P1("P1","Blacklisted"),
    SG("SG","Blacklisted"),
    TB("TB","Blacklisted"),

    Y0("Y0","Blacklisted"),
    Y1("Y1","Blacklisted"),

    YA("YA","Blacklisted"),
    YP("YP","Blacklisted"),
    YT("YT","Blacklisted"),
    YW("YW","Blacklisted"),
    YZ("YZ","Blacklisted"),

    ZC("ZC","Blacklisted"),
    ZF("ZF","Blacklisted"),
    ZW("ZW","Blacklisted"),
    ZY("ZY","Blacklisted"),

    DEFAULT("NEW","New Series by NSE");

    private String classification;
    private String description;

    private NSEClassification(String classification){
        this.classification = classification;
    }

    private NSEClassification(String classification, String description) {
        this.classification = classification;
        this.description = description;
    }

    public String getClassification(){
        return this.classification;
    }

    public String getDescription(){
        return this.description;
    }
}
