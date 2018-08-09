package kz.djunglestones.jobtask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;
    private HashMap<Integer, Integer> mChildCheckStates;
    private ChildViewHolder childViewHolder;
    private GroupViewHolder groupViewHolder;


    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
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
            convertView = inflater.inflate(R.layout.expandablelist_group,null);
            groupViewHolder = new GroupViewHolder();
//            groupViewHolder.textViewGroup = (TextView)convertView.findViewById(R.id.expandablelist_group_tv);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }


//        TextView lblListeader = (TextView)convertView.findViewById(R.id.expandablelist_group_tv);
//        lblListeader.setText(headerTitle);
//        groupViewHolder.textViewGroup.setText(headerTitle);
//        ExpandableListView expandableListView = (ExpandableListView)parent;
//        expandableListView.expandGroup(0);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final int mGroupPosition = groupPosition;
        final int mChildPosition = childPosition;

        final String childText = (String)getChild(groupPosition,childPosition);


        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandablelist_list,null);

            childViewHolder = new ChildViewHolder();
//            childViewHolder.textViewChild = (TextView)convertView.findViewById(R.id.expandablelist_list_tv);
//            convertView.setTag(childViewHolder);
        }
//        else{
//            childViewHolder = (ChildViewHolder)convertView.getTag();
//        }

//        RadioButton radioButton = (RadioButton)convertView.findViewById(R.id.expandablelist_list_radio_btn);
//        childViewHolder.textViewChild.setText(childText);
//
//
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

//        childViewHolder.radioButton.setOnCheckedChangeListener(null);
//
//        if (mChildCheckStates.containsKey(mGroupPosition)){
////            *
////			 * if the hashmap mChildCheckStates<Integer, Boolean[]> contains
////			 * the value of the parent view (group) of this child (aka, the key),
////			 * then retrive the boolean array getChecked[]
////			*/
//            Toast.makeText(context,"IF "+mChildPosition,Toast.LENGTH_SHORT).show();
//
//            boolean getChecked[] = mChildCheckStates.get(mGroupPosition);
//
//            childViewHolder.radioButton.setChecked(getChecked[mChildPosition]);
//
//        }else {
//            /*
//             * if the hashmap mChildCheckStates<Integer, Boolean[]> does not
//             * contain the value of the parent view (group) of this child (aka, the key),
//             * (aka, the key), then initialize getChecked[] as a new boolean array
//             *  and set it's size to the total number of children associated with
//             *  the parent group
//             */
//            Toast.makeText(context,"ELSE "+mChildPosition,Toast.LENGTH_SHORT).show();
//
//
//            boolean getChecked[] = new boolean[getChildrenCount(mGroupPosition)];
//
//            // add getChecked[] to the mChildCheckStates hashmap using mGroupPosition as the key
//            mChildCheckStates.put(mGroupPosition, getChecked);
//
//            // set the check state of this position's checkbox based on the
//            // boolean value of getChecked[position]
//            childViewHolder.radioButton.setChecked(false);
//
//        }
//
//
//        childViewHolder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if (isChecked) {
////                    Toast.makeText(context,"Checked"+mChildPosition,Toast.LENGTH_SHORT).show();
//
//                    boolean getChecked[] = mChildCheckStates.get(mGroupPosition);
//                    getChecked[mChildPosition] = isChecked;
//                    mChildCheckStates.put(mGroupPosition, getChecked);
//
//                } else {
////                    Toast.makeText(context,"NOT Checked"+mChildPosition,Toast.LENGTH_SHORT).show();
//
//                    boolean getChecked[] = mChildCheckStates.get(mGroupPosition);
//                    getChecked[mChildPosition] = isChecked;
//                    mChildCheckStates.put(mGroupPosition, getChecked);
//                }
//            }
//        });

//        return convertView;
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
