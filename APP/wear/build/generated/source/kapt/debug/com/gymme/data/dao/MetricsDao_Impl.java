package com.gymme.data.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gymme.data.data.LocalMetrics;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MetricsDao_Impl implements MetricsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocalMetrics> __insertionAdapterOfLocalMetrics;

  public MetricsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocalMetrics = new EntityInsertionAdapter<LocalMetrics>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `metrics` (`Id`,`Series`,`Repetitions`,`Load`,`ExecutionTime`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocalMetrics value) {
        stmt.bindLong(1, value.getId());
        if (value.getSeries() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getSeries());
        }
        if (value.getRepetitions() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getRepetitions());
        }
        if (value.getLoad() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getLoad());
        }
        if (value.getExecutionTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getExecutionTime());
        }
      }
    };
  }

  @Override
  public Object insert(final List<LocalMetrics> metrics, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocalMetrics.insert(metrics);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object get(final Continuation<? super List<LocalMetrics>> p0) {
    final String _sql = "SELECT * FROM metrics";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<LocalMetrics>>() {
      @Override
      public List<LocalMetrics> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfSeries = CursorUtil.getColumnIndexOrThrow(_cursor, "Series");
          final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "Repetitions");
          final int _cursorIndexOfLoad = CursorUtil.getColumnIndexOrThrow(_cursor, "Load");
          final int _cursorIndexOfExecutionTime = CursorUtil.getColumnIndexOrThrow(_cursor, "ExecutionTime");
          final List<LocalMetrics> _result = new ArrayList<LocalMetrics>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LocalMetrics _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Integer _tmpSeries;
            if (_cursor.isNull(_cursorIndexOfSeries)) {
              _tmpSeries = null;
            } else {
              _tmpSeries = _cursor.getInt(_cursorIndexOfSeries);
            }
            final Integer _tmpRepetitions;
            if (_cursor.isNull(_cursorIndexOfRepetitions)) {
              _tmpRepetitions = null;
            } else {
              _tmpRepetitions = _cursor.getInt(_cursorIndexOfRepetitions);
            }
            final Integer _tmpLoad;
            if (_cursor.isNull(_cursorIndexOfLoad)) {
              _tmpLoad = null;
            } else {
              _tmpLoad = _cursor.getInt(_cursorIndexOfLoad);
            }
            final Integer _tmpExecutionTime;
            if (_cursor.isNull(_cursorIndexOfExecutionTime)) {
              _tmpExecutionTime = null;
            } else {
              _tmpExecutionTime = _cursor.getInt(_cursorIndexOfExecutionTime);
            }
            _item = new LocalMetrics(_tmpId,_tmpSeries,_tmpRepetitions,_tmpLoad,_tmpExecutionTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
