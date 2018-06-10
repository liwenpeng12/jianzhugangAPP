package com.jlkg.jzg.jzg_android.home.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by zcs on 2018/3/22.
 */

public class MsgListBean {

    /**
     * content : [{"id":1,"title":"中央释放的这些改革信号 将影响你的买房决定","notes":"【读数】从今年\u201c十一\u201d前后，到11月底的两个月时间里，中国24个城市进行了50余次房地产市场调控，如今，这轮调控尚没有结束，就在12月21日，郑州、武汉再次发布了加码收紧购房的政策。\r\n\r\n【分析】\u201c郑州、武汉此轮出台的政策都是对原有调控政策的一次升级，体现了近期热点二线城市积极管控房地产市场的决心。\u201d易居研究院智库中心研究总监严跃进认为，后续还会有城市继续加入到限购限贷的行列，或者继续加码。目前，石家庄、青岛、长沙、重庆等城市总体上炒房需求较大，如果此类城市房价上涨节奏比较快，不排除后续出台相应的收紧政策的可能。","noteDate":"2018-03-22 15:15:38"},{"id":2,"title":"热点城市楼市降温 房价走势明显趋缓","notes":"【读数】11月，70城新建商品住宅和二手住宅价格环比上涨的城市个数减少，分别比上月减少7个和8个。与11月上半月比，11月下半月15个一线和热点二线城市中，北京、天津、上海、杭州等9个城市新建商品住宅价格环比下降。\r\n\r\n【分析】大范围、高强度的楼市调控，有效遏制了房价上涨的势头。\u201c从数据来看，一线和热点二线城市楼市迅速降温，房价走势明显趋缓。\u201d国家统计局城市司高级统计师刘建伟称。\r\n\r\n在张大伟看来，因为政策收紧、本轮楼市调控导致的房价涨幅拐点已经出现。来自中原地产12月19日的最新分析称，预计本轮调控周期起码持续6-9个月，20个热点城市房价将出现10%以上的下调空间。\r\n\r\n严跃进认为，鉴于11月房价环比上涨较快的城市均为三线城市，且主要是京津冀、长三角、珠三角这三大城市群中的三线城市，故这些城市需要提防返乡置业需求释放时，房价快速上涨的风险。","noteDate":"2018-03-23 15:16:29"},{"id":3,"title":"楼市将怎么走?中央释放这些改革信号","notes":"【定调】12月16日正式闭幕的中央经济工作会议提出了\u201c房子是用来住的，不是用来炒的\u201d 的定位。还明确，综合运用金融、土地、财税、投资、立法等手段，加快研究建立符合国情、适应市场规律的基础性制度和长效机制，既抑制房地产泡沫，又防止出现大起大落。\r\n\r\n【分析】中国城市经济学会副会长牛凤瑞表示，\u201c要解决炒房问题首先就得稳房价，而稳房价的前提则是要增加供给。\u201d\r\n\r\n会议就指出，要加快住房租赁市场立法，加快机构化、规模化租赁企业发展。在严跃进看来，发展住房租赁市场可有效满足城市各层次住房者的租赁需求和改善城市住房结构。\r\n\r\n\u201c针对一、二线土地市场供应不足导致的地价、房价上涨，可以从两个层面来解决。\u201d中国社科院城市与竞争力研究中心主任倪鹏飞建言称，首先要加大土地供应指标，采取人地挂钩模式;其次由于一、二线城市存量土地比较多，同样有盘活的余地。","noteDate":"2018-03-24 15:16:56"}]
     * last : true
     * totalElements : 3
     * totalPages : 1
     * size : 10
     * number : 0
     * sort : null
     * first : true
     * numberOfElements : 3
     */

    private boolean last;
    private int totalElements;
    private int totalPages;
    private int size;
    private int number;
    private Object sort;
    private boolean first;
    private int numberOfElements;
    private List<ContentBean> content;

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Object getSort() {
        return sort;
    }

    public void setSort(Object sort) {
        this.sort = sort;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean implements Parcelable {
        /**
         * id : 1
         * title : 中央释放的这些改革信号 将影响你的买房决定
         * notes : 【读数】从今年“十一”前后，到11月底的两个月时间里，中国24个城市进行了50余次房地产市场调控，如今，这轮调控尚没有结束，就在12月21日，郑州、武汉再次发布了加码收紧购房的政策。

         【分析】“郑州、武汉此轮出台的政策都是对原有调控政策的一次升级，体现了近期热点二线城市积极管控房地产市场的决心。”易居研究院智库中心研究总监严跃进认为，后续还会有城市继续加入到限购限贷的行列，或者继续加码。目前，石家庄、青岛、长沙、重庆等城市总体上炒房需求较大，如果此类城市房价上涨节奏比较快，不排除后续出台相应的收紧政策的可能。
         * noteDate : 2018-03-22 15:15:38
         */

        private int id;
        private String title;
        private String notes;
        private String noteDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getNoteDate() {
            return noteDate;
        }

        public void setNoteDate(String noteDate) {
            this.noteDate = noteDate;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.title);
            dest.writeString(this.notes);
            dest.writeString(this.noteDate);
        }

        public ContentBean() {
        }

        protected ContentBean(Parcel in) {
            this.id = in.readInt();
            this.title = in.readString();
            this.notes = in.readString();
            this.noteDate = in.readString();
        }

        public static final Parcelable.Creator<ContentBean> CREATOR = new Parcelable.Creator<ContentBean>() {
            @Override
            public ContentBean createFromParcel(Parcel source) {
                return new ContentBean(source);
            }

            @Override
            public ContentBean[] newArray(int size) {
                return new ContentBean[size];
            }
        };
    }
}
