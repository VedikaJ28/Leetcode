class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        checkAllBoards(result,new ArrayList<>(),n,new ArrayList<>(),new HashSet<>(),new HashSet<>(),0);
        return result;
    }
    public void checkAllBoards(List<List<String>> result,List<String> tempList,int n,List<Integer> col,Set<Integer> diag1,Set<Integer> diag2,int row){
        if(row==n){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<n;i++){
            if(!col.contains(i) && !diag1.contains(row - i) && !diag2.contains(row + i)){
                col.add(i);
                diag1.add(row-i);
                diag2.add(row+i);

                StringBuilder str = new StringBuilder(".".repeat(n));
                str.setCharAt(i,'Q');
                tempList.add(str.toString());
                checkAllBoards(result,tempList,n,col,diag1,diag2,row+1);
                col.remove(col.size()-1);
                diag1.remove(row-i);
                diag2.remove(row+i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}