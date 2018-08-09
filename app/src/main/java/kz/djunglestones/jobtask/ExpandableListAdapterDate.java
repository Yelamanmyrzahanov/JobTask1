package kz.djunglestones.jobtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapterDate extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;
    private HashMap<Integer, Integer> mChildCheckStates;
    private ChildViewHolder childViewHolder;
    private GroupViewHolder groupViewHolder;

    public ExpandableListAdapterDate(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
        mChildCheckStates = new HashMap<Integer, Integer>();
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = (String)getGroup(groupPosition);

        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandablelist_group_date,null);
            groupViewHolder = new GroupViewHolder();
//            groupViewHolder.textViewGroup = (TextView)convertView.findViewById(R.id.expandablelist_group_date_tv);
            convertView.setTag(groupViewHolder);
        }
        else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }

//        groupViewHolder.textViewGroup.setText(headerTitle);
//        ExpandableListView expandableListView = (ExpandableListView)parent;
//        expandableListView.expandGroup(groupPosition);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final int mGroupPosition = groupPosition;
        final int mChildPosition = childPosition;

        final String childText = (String)getChild(groupPosition,childPosition);

        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandablelist_list_date,null);

            childViewHolder = new ChildViewHolder();
//            childViewHolder.textViewChild = (TextView)convertView.findViewById(R.id.expandablelist_list_date_tv);
//            convertView.setTag(childViewHolder);
        }
//        else{
//            childViewHolder = (ChildViewHolder)convertView.getTag();
//        }

//        RadioButton radioButton = (RadioButton)convertView.findViewById(R.id.expandablelist_list_date_radio_btn);
//        childViewHolder.textViewChild.setText(childText);


//        try {
//            radioButton.setChecked(mChildPosition == mChildCheckStates.get(groupPosition));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        radioButton.setTag(childPosition);
//
//        radioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mChildCheckStates.put(mGroupPosition, (Integer) v.getTag());
//                notifyDataSetChanged();
//            }
//        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class ChildViewHolder {

        TextView textViewChild;
        RadioButton radioButton;

    }

    private class GroupViewHolder {
        TextView textViewGroup;
    }
}
