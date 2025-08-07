package retrofit2.adapter.java8;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class Java8CallAdapterFactory extends CallAdapter.Factory {
    public static Java8CallAdapterFactory create() {
        return new Java8CallAdapterFactory();
    }

    private Java8CallAdapterFactory() {
    }

    public CallAdapter<?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
            if (getRawType(parameterUpperBound) != Response.class) {
                return new BodyCallAdapter(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }

    private static class BodyCallAdapter implements CallAdapter<CompletableFuture<?>> {
        private final Type responseType;

        BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        public Type responseType() {
            return this.responseType;
        }

        public <R> CompletableFuture<R> adapt(final Call<R> call) {
            final AnonymousClass1 r0 = new CompletableFuture<R>() {
                public boolean cancel(boolean z) {
                    if (z) {
                        call.cancel();
                    }
                    return super.cancel(z);
                }
            };
            call.enqueue(new Callback<R>() {
                public void onResponse(Call<R> call, Response<R> response) {
                    if (response.isSuccessful()) {
                        r0.complete(response.body());
                    } else {
                        r0.completeExceptionally(new HttpException(response));
                    }
                }

                public void onFailure(Call<R> call, Throwable th) {
                    r0.completeExceptionally(th);
                }
            });
            return r0;
        }
    }

    private static class ResponseCallAdapter implements CallAdapter<CompletableFuture<?>> {
        private final Type responseType;

        ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        public Type responseType() {
            return this.responseType;
        }

        public <R> CompletableFuture<Response<R>> adapt(final Call<R> call) {
            final AnonymousClass1 r0 = new CompletableFuture<Response<R>>() {
                public boolean cancel(boolean z) {
                    if (z) {
                        call.cancel();
                    }
                    return super.cancel(z);
                }
            };
            call.enqueue(new Callback<R>() {
                public void onResponse(Call<R> call, Response<R> response) {
                    r0.complete(response);
                }

                public void onFailure(Call<R> call, Throwable th) {
                    r0.completeExceptionally(th);
                }
            });
            return r0;
        }
    }
}
