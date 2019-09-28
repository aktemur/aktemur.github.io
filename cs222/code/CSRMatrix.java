public class CSRMatrix {
    private int numRows;    
    private int numCols;    
    private int numNZ;
    private int[] rows;
    private int[] cols;
    private double[] vals;

    public CSRMatrix(int n, int m, int nz) {
        numRows = n;
        numCols = m;
        numNZ = nz;
    }

    public void setRows(int[] rows) {
        this.rows = rows;
    }

    public void setCols(int[] cols) {
        this.cols = cols;
    }

    public void setVals(double[] vals) {
        this.vals = vals;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(numRows + " " + numCols + " " + numNZ + "\n");		

        appendVals(buffer);
        appendCols(buffer);
        appendRows(buffer);

        return buffer.toString();
    }

    private void appendVals(StringBuffer buffer) {
        buffer.append("vals = {\n");
        for(int i = 0; i < vals.length; i++) {
            buffer.append(vals[i] + ",\n");
        }
        buffer.append("}\n");
    }

    private void appendCols(StringBuffer buffer) {
        buffer.append("cols = {\n");
        for(int i = 0; i < cols.length; i++) {
            buffer.append(cols[i] + ",\n");
        }
        buffer.append("}\n");
    }

    private void appendRows(StringBuffer buffer) {
        buffer.append("rows = {\n");
        for(int i = 0; i < rows.length; i++) {
            buffer.append(rows[i] + ",\n");
        }
        buffer.append("}\n");
    }
}