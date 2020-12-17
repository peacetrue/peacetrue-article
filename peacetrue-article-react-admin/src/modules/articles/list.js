import React from 'react';
import {Datagrid, DateField, DateInput, EditButton, Filter, List, TextField, TextInput} from 'react-admin';

const Filters = (props) => (
    <Filter {...props}>
        <TextInput label={'类型编码'} source="typeCode" allowEmpty alwaysOn resettable/>
        <TextInput label={'封面'} source="cover" allowEmpty alwaysOn resettable/>
        <TextInput label={'标题'} source="title" allowEmpty alwaysOn resettable/>
        <TextInput label={'简介'} source="intro" allowEmpty alwaysOn resettable/>
        <TextInput label={'详情'} source="detail" allowEmpty alwaysOn resettable/>
        <TextInput label={'备注'} source="remark" allowEmpty alwaysOn resettable/>
        <DateInput label={'创建时间起始值'} source="createdTime.lowerBound" allowEmpty alwaysOn/>
        <DateInput label={'创建时间结束值'} source="createdTime.upperBound" allowEmpty alwaysOn/>
        <DateInput label={'修改时间起始值'} source="modifiedTime.lowerBound" allowEmpty alwaysOn/>
        <DateInput label={'修改时间结束值'} source="modifiedTime.upperBound" allowEmpty alwaysOn/>
    </Filter>
);

export const ArticleList = props => {
    console.info('ArticleList:', props);
    return (
        <List {...props} filters={<Filters/>}>
            <Datagrid rowClick="show">
                <TextField source="typeId"/>
                <TextField source="typeCode"/>
                <TextField source="cover"/>
                <TextField source="title"/>
                <TextField source="intro"/>
                <TextField source="detail"/>
                <TextField source="remark"/>
                <TextField source="serialNumber"/>
                <TextField source="creatorId"/>
                <DateField source="createdTime" showTime/>
                <TextField source="modifierId"/>
                <DateField source="modifiedTime" showTime/>
                <EditButton/>
            </Datagrid>
        </List>
    )
};
