import React from "react";
import {Resource} from "react-admin";

import {ArticleList} from './list';
import {ArticleCreate} from './create';
import {ArticleEdit} from './edit';
import {ArticleShow} from './show';

export const Article = {list: ArticleList, create: ArticleCreate, edit: ArticleEdit, show: ArticleShow};
const ArticleResource = <Resource name="articles" {...Article} />;
export default ArticleResource;
