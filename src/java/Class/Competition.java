package Class;

import Prototype.IClone;

public class Competition implements IClone {
    
    private int competitionId;
    private String title;
    private String category;
    private int headquarterId;

    public Competition(int competitionId, String title, String category, int headquarterId){
        this.competitionId = competitionId;
        this.title = title;
        this.category = category;
        this.headquarterId = headquarterId;
    }
    
    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public int getHeadquarterId() {
        return headquarterId;
    }

    public void setHeadquarterId(int headquarterId) {
        this.headquarterId = headquarterId;
    }

    @Override
    public IClone clone() {
        IClone competition = new Competition(this.competitionId, this.title, this.category, this.headquarterId);
        return competition;
    }
    
}
