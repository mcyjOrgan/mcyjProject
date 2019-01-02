package common.util;

public class PicAttr {
    private String path;
    
    private Integer heigth;
    
    private Integer width;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getHeigth() {
        return (heigth == null)?0:heigth;
    }

    public void setHeigth(Integer heigth) {
        this.heigth = heigth;
    }

    public Integer getWidth() {
        return (width == null)?0:width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
    
    public String toString(){
        return "path: " + path + "; width: " + width + "; heigth: " + heigth;
    }
}
