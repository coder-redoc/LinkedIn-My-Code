package onsite;
import java.util.*;
/*
 * 一个说话声音很轻没精打采的烙印，一副我欠他钱的样子，给一个list的set，
 * {{a,b,c},{d},{e,f}}，输出它们的Cartesian product 
 * {a,d,e},{a,d,f},{b,d,e},{b,d,f},{c,d,e},{c,d,f}，recursive做好后要用iterative的for循环来写
 */
public class CartesianProduct {
	public List<List<Character>> iterativeCartesianProduct(List<Set<Character>> sets){
		List<List<Character>> res=new ArrayList<List<Character>>();
		List<List<Character>> dic=new ArrayList<List<Character>>();
		int total=1;
		for(int i=0;i<sets.size();i++){
			Set<Character> curr=sets.get(i);
			total=total*curr.size();
			List<Character> toadd=new ArrayList<Character>();
			toadd.addAll(curr);
			dic.add(toadd);
		}
		int[] indexes=new int[sets.size()];
		for(int i=0;i<total;i++){
			List<Character> toadd=new ArrayList<Character>();
			for(int j=0;j<indexes.length;j++){
				toadd.add(dic.get(j).get(indexes[j]));
			}
			int add=1;
			int index=indexes.length-1;
			while(add>0&&index>=0){
				indexes[index]++;
				add=indexes[index]/dic.get(index).size();
				indexes[index]=indexes[index]%dic.get(index).size();
				index--;
			}
			res.add(toadd);
		}
		return res;
	}
}
