import React from 'react';
import {DateField, Show, SimpleShowLayout, TextField} from 'react-admin';

export const ArticleShow = (props) => {
    console.info('ArticleShow:', props);
    return (
        <Show {...props}>
            <SimpleShowLayout>
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
            </SimpleShowLayout>
        </Show>
    );
};
