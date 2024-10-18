class Solution {
    public boolean isValidSudoku(char[][] board) {
        
    for (int i = 0; i < board.length; i++) {
    HashSet<Integer> col = new HashSet<Integer>();  // Set to store column values
    for (int j = 0; j < board[i].length; j++) {
        if(board[i][j] == '.') continue;
        int value = board[i][j] - '0';  // Convert char to int (assuming numeric characters)
        
        if (!col.contains(value)) {  // Check if the value is already in the set
            col.add(value);  // Add the value to the set if it's not present
        } else {
            return false;  // If the value is already present, return false
        }
    }
}


        for (int j = 0; j < board.length; j++) {
    HashSet<Integer> row = new HashSet<Integer>();  // Set to store row values
    for (int i = 0; i < board.length; i++) {
        if(board[i][j] == '.') continue;

        int value = board[i][j] - '0';  // Convert char to int (assuming numeric characters)
        
        if (!row.contains(value)) {  // Check if the value is already in the set
            row.add(value);  // Add the value to the set if it's not present
        } else {
            return false;  // If the value is already present, return false
        }
    }
}

       for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        int rowStart = i * 3;
        int colStart = j * 3;
        HashSet<Integer> box = new HashSet<Integer>();  // Use 'box' to avoid conflict with row variable
        for (int k = rowStart; k < rowStart + 3; k++) {
            for (int l = colStart; l < colStart + 3; l++) {
        if(board[k][l] == '.') continue;

                int value = board[k][l] - '0';  // Convert char to integer (assuming numeric characters)
                
                if (!box.contains(value)) {
                    box.add(value);  // Add the value to the set if it's not present
                } else {
                    return false;  // If the value is already present, return false
                }
            }
        }
    }
}

        return true;


        
    }
}