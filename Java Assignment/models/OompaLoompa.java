package models;

public class OompaLoompa extends Beings{
	
	private int height;
	private String favoriteFood;
	
	public OompaLoompa (){}
	public OompaLoompa (String name, String code, int height, String favoriteFood){
		super(name,code);
		this.height = height;
		this.favoriteFood = favoriteFood;
	}
	
	//getters and setters
    public int getHeight()
    {
        return this.height;
    }
	
	public void setHeight(int _height)
    {
        this.height=_height;
    }
	
    public String getFavoriteFood()
    {
        return this.favoriteFood;
    }

    public void setFavoriteFood(String _favoriteFood)
    {
        this.favoriteFood=_favoriteFood;
    }
}