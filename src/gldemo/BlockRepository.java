package gldemo;

import java.util.HashMap;

public class BlockRepository {
	HashMap<Integer,Block>  map=new HashMap<Integer,Block> ();
	
	public void put(Block block){
		map.put(block.x*1000000+block.z*1000+block.y,block);
	}
	public boolean haveObject(int x,int y,int z){
		if(y<=0)
			return true;
		return map.get(x*1000000+z*1000+y)!=null;
	}
}
