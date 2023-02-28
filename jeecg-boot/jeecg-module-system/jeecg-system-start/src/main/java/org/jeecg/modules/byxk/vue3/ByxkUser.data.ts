import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '姓名 ',
    align:"center",
    dataIndex: 'username'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'sex'
   },
   {
    title: '证件号',
    align:"center",
    dataIndex: 'idcard'
   },
   {
    title: '手机号',
    align:"center",
    dataIndex: 'phone'
   },
   {
    title: '工作岗位',
    align:"center",
    dataIndex: 'post'
   },
   {
    title: '部门',
    align:"center",
    dataIndex: 'dept'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '姓名 ',
    field: 'username',
    component: 'Input',
  },
  {
    label: '性别',
    field: 'sex',
    component: 'Input',
  },
  {
    label: '证件号',
    field: 'idcard',
    component: 'Input',
  },
  {
    label: '手机号',
    field: 'phone',
    component: 'Input',
  },
  {
    label: '工作岗位',
    field: 'post',
    component: 'Input',
  },
  {
    label: '部门',
    field: 'dept',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];



/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}