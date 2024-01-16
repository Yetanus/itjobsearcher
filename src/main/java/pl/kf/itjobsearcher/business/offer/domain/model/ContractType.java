package pl.kf.itjobsearcher.business.offer.domain.model;

public enum ContractType {
    UOP("Umowa o prace"),
    B2B("B2B"),
    UZ("Umowa zlecenie"),
    UD("Umowa o dzieło");

    private String typeOfContract;

    ContractType(String typeOfC)
    {
        this.typeOfContract = typeOfC;
    }

    public String getContract(){
        return typeOfContract;
    }
}
