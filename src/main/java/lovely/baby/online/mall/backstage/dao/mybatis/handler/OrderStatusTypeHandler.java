package lovely.baby.online.mall.backstage.dao.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import lovely.baby.online.mall.backstage.model.OrderStatus;
import lovely.baby.online.mall.backstage.util.HasCodeUtils;

public class OrderStatusTypeHandler extends BaseTypeHandler<OrderStatus> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrderStatus parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public OrderStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return HasCodeUtils.getInstance(rs.getInt(columnName), OrderStatus.class);
    }

    @Override
    public OrderStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return HasCodeUtils.getInstance(rs.getInt(columnIndex), OrderStatus.class);
    }

    @Override
    public OrderStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return HasCodeUtils.getInstance(cs.getInt(columnIndex), OrderStatus.class);
    }
}
