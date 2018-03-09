package entity;

public class PictureDTO {
    String pictureUrl;

    public PictureDTO() {
    }

    public PictureDTO(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
