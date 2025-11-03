FROM eclipse-temurin:17-jre
COPY app.jar app.jar
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.31.0/opentelemetry-javaagent.jar /otel.jar
ENV JAVA_TOOL_OPTIONS="-javaagent:/otel.jar"
ENV OTEL_SERVICE_NAME=downstream
ENV OTEL_TRACES_EXPORTER=otlp
ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://jaeger-collector.istio-system.svc.cluster.local:4317
ENV OTEL_PROPAGATORS=b3
ENTRYPOINT ["java","-jar","/app.jar"]
