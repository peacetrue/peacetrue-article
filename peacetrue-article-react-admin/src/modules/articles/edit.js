import React from 'react';
import {Edit, maxLength, minValue, NumberInput, required, SimpleForm, TextInput} from 'react-admin';

export const ArticleEdit = (props) => {
    console.info('ArticleEdit:', props);
    return (
        <Edit {...props} undoable={false}>
            <SimpleForm>
                <NumberInput source="typeId" validate={[required(), minValue(0)]} min={0}/>
                <TextInput source="typeCode" validate={[required(), maxLength(32)]}/>
                <TextInput source="cover" validate={[required(), maxLength(255)]}/>
                <TextInput source="title" validate={[required(), maxLength(32)]}/>
                <TextInput source="intro" validate={[required(), maxLength(255)]}/>
                <TextInput source="detail" validate={[required(), maxLength(20480)]}/>
                <TextInput source="remark" validate={[required(), maxLength(255)]}/>
                <NumberInput source="serialNumber" validate={[required(), minValue(0)]} min={0}/>
            </SimpleForm>
        </Edit>
    );
};
