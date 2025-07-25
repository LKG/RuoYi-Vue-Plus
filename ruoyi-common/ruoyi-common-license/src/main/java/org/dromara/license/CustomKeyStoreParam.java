package org.dromara.license;

import de.schlichtherle.license.AbstractKeyStoreParam;
import lombok.*;

/**
 * @author gg
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CustomKeyStoreParam extends AbstractKeyStoreParam{
    /**
     * 密钥路径，可为磁盘路径，也可为项目资源文件里的路径,如果为磁盘路径需重写getStream()方法
     */
    private String storePath;

    /**
     * 公钥或私钥的别名
     */
    private String alias;

    /**
     * 访问公钥/私钥库的密码
     */
    private String storePwd;

    /**
     * 公钥/私钥的密码
     */
    private String keyPwd;
    /**
     * Creates a new instance of AbstractKeyStoreParam which will look up
     * the given resource using the class loader of the given class when
     * calling {@link #getStream()}.
     *
     * @param clazz    the class which refers to the class loader to use.
     * @param resource the resource to look up.
     */
    public CustomKeyStoreParam(Class clazz, String resource) {
        super(clazz, resource);
    }

    public CustomKeyStoreParam(Class clazz, String resource, String alias, String storePwd, String keyPwd) {
        super(clazz, resource);
        this.storePath = resource;
        this.alias = alias;
        this.storePwd = storePwd;
        this.keyPwd = keyPwd;
    }
}
