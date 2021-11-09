package labs.lab13;

import java.util.Date;
import java.util.List;

public class WikiJSON {
    public Continue aContinue;
    public Searchinfo searchinfo;
    public Search search;
    public Query query;
    public Root root;

    public class Continue{
        public int sroffset;
        public String contin;
    }

    public class Searchinfo{
        public int totalhits;
    }

    public class Search{
        public int ns;
        public String title;
        public int pageid;
        public int size;
        public int wordcount;
        public String snippet;
        public Date timestamp;
    }

    public class Query{
        public Searchinfo searchinfo;
        public List<Search> search;
    }

    public class Root{
        public String batchcomplete;
        public Continue contin;
        public Query query;
    }


}
