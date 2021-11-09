package labs.lab13;

import java.util.Date;
import java.util.List;



    class Continue{
        public int sroffset;
        public String contin;
    }

    class Searchinfo{
        public int totalhits;
    }

    class Search{
        public int ns;
        public String title;
        public int pageid;
        public int size;
        public int wordcount;
        public String snippet;
        public Date timestamp;
    }

    class Query{
        public Searchinfo searchinfo;
        public List<Search> search;
    }

    class Root{
        public String batchcomplete;
        public Continue contin;
        public Query query;
    }


