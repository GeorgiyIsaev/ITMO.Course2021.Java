package labs.lab13;

import java.util.Date;
import java.util.List;



    class Continue{
        public int sroffset;
        public String contin;

        @Override
        public String toString() {
            return "Continue{" +
                    "sroffset=" + sroffset +
                    ", contin='" + contin + '\'' +
                    '}';
        }
    }

    class Searchinfo{
        public int totalhits;

        @Override
        public String toString() {
            return "Searchinfo{" +
                    "totalhits=" + totalhits +
                    '}';
        }
    }

    class Search{
        public int ns;
        public String title;
        public int pageid;
        public int size;
        public int wordcount;
        public String snippet;
        public Date timestamp;

        @Override
        public String toString() {
            return "Search{" +
                    "ns=" + ns +
                    ", title='" + title + '\'' +
                    ", pageid=" + pageid +
                    ", size=" + size +
                    ", wordcount=" + wordcount +
                    ", snippet='" + snippet + '\'' +
                    ", timestamp=" + timestamp +
                    '}'+'\n';
        }
    }

    class Query{
        public Searchinfo searchinfo;
        public List<Search> search;

        @Override
        public String toString() {
            return "Query{" +
                    "searchinfo=" + searchinfo +
                    ", search=" + search.toString() +
                    '}';
        }
    }

    class Root{
        public String batchcomplete;
        public Continue contin;
        public Query query;

        @Override
        public String toString() {
            return "Root{" +
                    "batchcomplete='" + batchcomplete + '\'' +
                    ", contin=" + contin +
                    ", query=" + query +
                    '}';
        }

        public String fomatStringText(){
            String myText="";
            for (Search search : query.search){
                myText +=  search.snippet + " ";
            }

            myText = myText.replace ("<span class=\"searchmatch\">", "");
            myText = myText.replace ("</span>", "");

            StringBuffer strBuffer = new StringBuffer(myText);
            for (int i = 80; i < myText.length(); i++) {
                if(i % 80 == 0)
                    for (int j = i; j <myText.length(); j++) {
                        if(' ' == strBuffer.charAt(j)){
                            strBuffer.insert(j +1, '\n');
                            break;
                        }
                    }
            }
            return strBuffer.toString();

        }
    }


